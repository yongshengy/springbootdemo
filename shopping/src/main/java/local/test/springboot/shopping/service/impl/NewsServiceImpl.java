package local.test.springboot.shopping.service.impl;

import local.test.springboot.shopping.entity.News;
import local.test.springboot.shopping.repository.NewsRepository;
import local.test.springboot.shopping.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findForMain() {
        return newsRepository.findForMain();
    }

    @Override
    public List<News> findByPage(int page,int limit) {
        return newsRepository.findLimit((page-1)*limit,limit);
    }

    @Override
    public int getPages(int limit) {
        int total = newsRepository.count();
        int page = 0;
        if(total%limit == 0){
            page = total/limit;
        }else{
            page = total/limit+1;
        }
        return page;
    }
}
