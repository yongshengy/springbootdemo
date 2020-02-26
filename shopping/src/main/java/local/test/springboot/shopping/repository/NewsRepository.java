package local.test.springboot.shopping.repository;

import local.test.springboot.shopping.entity.News;

import java.util.List;

public interface NewsRepository {
    public List<News> findForMain();
    public List<News> findLimit(int index, int limit);
    public int count();
}
