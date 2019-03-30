package technicalblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostService() {
        System.out.println("*** PostService ***");
    }

    public List<Post> getAllPosts()
    {
        ArrayList<Post> posts = new ArrayList<>();

    /*   Post post1= new Post();
       post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
      post1.setDate(new Date());

       Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        */

        /*
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "rajatsingh");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        return postRepository.getAllPosts();
    }


    public Post getOnePost() {

        ArrayList<Post> posts = new ArrayList<>();

/*
-------------- JDBC Implementation as Follows --------------------------

        Post post1 = new Post();
        post1.setTitle("This is your Post");
        post1.setBody("This is your Post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres", "rajatsingh");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts where id = 4");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
*/
        return postRepository.getLatestPost();

    }

    public void createPost(Post newPost)
    {
        newPost.setDate(new Date());
        postRepository.createPost(newPost);
        System.out.println("New Post " + newPost);
    }

    public Post getPost(Integer postid)
    {
        return postRepository.getPost(postid);
    }


    public void updatePost(Post updatedPost)
    {
         updatedPost.setDate(new Date());
         postRepository.updatePost(updatedPost);
    }

    public void deletePost(Integer postid)
    {
        postRepository.Deletepost(postid);
    }
}
