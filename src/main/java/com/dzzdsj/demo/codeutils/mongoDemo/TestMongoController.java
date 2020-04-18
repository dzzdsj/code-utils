package com.dzzdsj.demo.codeutils.mongoDemo;

import com.dzzdsj.demo.codeutils.mongoDemo.entity.Baike;
import com.dzzdsj.demo.codeutils.mongoDemo.entity.Comment;
import com.dzzdsj.demo.codeutils.mongoDemo.entity.SimplePage;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestMongoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**插入*/
    @GetMapping("/mongoAdd")
    public Baike mongoAdd(){
        Baike baike = new Baike();
        baike.setId("c++");
        baike.setDesc("面向对象的高级语言");
        List<String> tag = new ArrayList<>();
        tag.add("功能强大");
        tag.add("复杂");
        baike.setTag(tag);
        Comment comment = new Comment();
        comment.setGood(500);
        comment.setBad(100);
        baike.setComment(comment);
        baike.setCreateDate(new Date());
        System.out.println("baike:"+baike);
        /**默认使用对象的首字母小写名称对应db中的集合名称，也可以指定名称*/
//        baike = mongoTemplate.insert(baike);//新增文档
        baike = mongoTemplate.insert(baike,"baike");//新增文档,并指定集合名称
        return baike;
    }

    /**根据主键查询*/
    @GetMapping("/mongoFindById/{id}")
    public Baike mongoFindById(@PathVariable String id){
        Baike baike = new Baike();
        System.out.println("baike:"+baike);
        baike = mongoTemplate.findById(id,Baike.class);//
        System.out.println(baike);
        return baike;
    }
    /**根据条件查询*/
    @GetMapping("/mongoQuery/{bad}")
    public List<Baike> mongoQuery(@PathVariable int bad){
        Criteria criteria = Criteria.where("comment.bad").gt(bad);
        List<Baike> baikeList = mongoTemplate.find(Query.query(criteria),Baike.class);//
        System.out.println(baikeList);
        return baikeList;
    }
    /**多条件查询，逻辑组合*/
    @GetMapping("/mongoQuery2/{bad}")
    public List<Baike> mongoQuery2(@PathVariable int bad){
        Criteria criteria = Criteria.where("comment.bad").gt(bad);
        Criteria criteria2 = Criteria.where("comment.good").lt(bad);
        List<Baike> baikeList = mongoTemplate.find(Query.query(criteria.andOperator(criteria2)),Baike.class);//
        System.out.println(baikeList);
        return baikeList;
    }
    /**分页查询*/
    @GetMapping("/mongoQueryPage/{pageNum}")
    public SimplePage mongoQueryPage(@PathVariable long pageNum){
        Criteria criteria = new Criteria();
        Query query = Query.query(criteria);
        long totolCount = mongoTemplate.count(query,Baike.class);//计算总数
        int numOfPage = 2;
        long totolPage = totolCount % numOfPage == 0 ? (totolCount / numOfPage) : (totolCount / numOfPage +1);//总页数
        long skip = (pageNum -1)*numOfPage;
        query.skip(skip).limit(numOfPage);//构建分页信息，再次查询
        List<Baike> baikeList = mongoTemplate.find(query,Baike.class);//
        //构造分页对象
        SimplePage simplePage = new SimplePage();
        simplePage.setTotolNum(totolCount);
        simplePage.setTotolPage(totolPage);
        simplePage.setCurrentPage(pageNum);
        simplePage.setDataList(baikeList);
        System.out.println(baikeList);
        return simplePage;
    }
    /**数据更新*/
    @GetMapping("/mongoUpdate/{id}")
    public String mongoUpdate(@PathVariable String id){
        Criteria criteria = Criteria.where("id").in(id);
        Update update = new Update();
        update.inc("comment.good",1);
        UpdateResult updateResult = mongoTemplate.updateMulti(Query.query(criteria),update,Baike.class);//
        System.out.println(updateResult);
        return "update:" + updateResult.getModifiedCount();
    }
    /**数据删除,推荐逻辑删除，加个status状态判断*/
    @GetMapping("/mongoDelete/{id}")
    public String mongoDelete(@PathVariable String id){
        Baike baike = new Baike();
        baike.setId(id);
        DeleteResult deleteResult = mongoTemplate.remove(baike);//
        System.out.println(deleteResult);
        return "delete:" + deleteResult.getDeletedCount();
    }
}
