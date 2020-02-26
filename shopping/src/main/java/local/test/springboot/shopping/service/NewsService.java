package local.test.springboot.shopping.service;

import local.test.springboot.shopping.entity.News;

import java.util.List;

public interface NewsService {
    public List<News> findForMain();
    public List<News> findByPage(int page, int limit);
    public int getPages(int limit);
}
