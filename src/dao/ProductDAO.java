package dao;

import entities.ProductEntity;
import util.HibernateUtility;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

  private final static SessionFactory factory = HibernateUtility.getSessionFactory();
  private Connection conn = null;
  private PreparedStatement ps = null;
  protected ResultSet rs = null;

  

  public List<ProductEntity> getListProduct()
  {
    Transaction transaction = null;
    List<ProductEntity> products = null;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      Query<ProductEntity> query = session.createQuery("FROM ProductEntity", ProductEntity.class);
      products = query.list();
      return products;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return null;
  }

  public void updateProduct(ProductEntity product) {
    Transaction transaction = null;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      // Error: https://www.baeldung.com/hibernate-detached-entity-passed-to-persist
      session.merge(product);
      transaction.commit();
      return;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return;
  }

  public void insertProduct(ProductEntity product) {
    Transaction transaction = null;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      session.persist(product);
      transaction.commit();
      return;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return;
  }

  public List<ProductEntity> searchProduct(String text)
  {
    Transaction transaction = null;
    List<ProductEntity> products = null;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      Query<ProductEntity> query = session.createQuery("FROM ProductEntity p WHERE p.title LIKE :txt OR p.color LIKE :txt OR p.description LIKE :txt", ProductEntity.class);
      query.setParameter("txt", "%"+text+"%");
      products = query.list();
      return products;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return null;
  }

  public ProductEntity getProductById(long productId)
  {
    Transaction transaction = null;
    ProductEntity product;
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      /*Query<ProductEntity> query = session.createQuery("FROM ProductEntity p WHERE p.id = ?", ProductEntity.class);
      query.setParameter(1, productId);
      product = query.getSingleResult();*/
      product = session.get(ProductEntity.class, productId);
      // fix error:
      product.getId();
      return product;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return null;
  }

  public void deleteProduct(long productId) {
    Transaction transaction = null;
    ProductEntity product = new ProductEntity();
    product.setId(productId);
    Session session = factory.openSession();
    try
    {
      transaction = session.beginTransaction();
      // Error Could not resolve root entity, Cannot resolve symbol 'Product Entity'
      // --> change version or use "jakarta.persistence" for version hibernate > 6.
      // https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate
      session.remove(product);
      transaction.commit();
      return;
    }
    catch (Exception e)
    {
      if (transaction != null)
      {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    finally
    {
      session.close();
    }
    return;
  }


  public static void main(String[] args) {
    ProductDAO productDAO = new ProductDAO();
    List<ProductEntity> products = productDAO.getListProduct();
    for (ProductEntity product : products) {
      System.out.println(product);
    }
  }
}
