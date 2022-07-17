package helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
        /*
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);

            tx.commit();
        */
        /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId = "+findMember.getId());
            System.out.println("findMember.getName = "+findMember.getName());
        */
        Member findMember = em.find(Member.class, 1L);
        findMember.setName("HelloJPA");

        Board findBoard = em.find(Board.class, 1L);
        System.out.println("findBoard.getId = "+findBoard.getId() );
        System.out.println("findBoard.getTitle = "+findBoard.getTitle() );
        System.out.println("findBoard.getContent = "+findBoard.getContent() );


        tx.commit();



        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
