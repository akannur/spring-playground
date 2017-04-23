package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by anup on 22/04/17.
 */
@WebMvcTest(MathController.class)
@RunWith(SpringRunner.class)
public class MathControllerTests {
  @Autowired
  MockMvc mvc;


  @Test
  public void testCalculateAdd() throws Exception {
    this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
        .andExpect(status().isOk())
        .andExpect(content().string("4 + 6 = 10"));
  }

   @Test
   public void testCalculateMultiply() throws Exception {
     this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6"))
         .andExpect(status().isOk())
         .andExpect(content().string("4 * 6 = 24"));
   }

   @Test
   public void testCalculateSubtract() throws Exception {
     this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6"))
         .andExpect(status().isOk())
         .andExpect(content().string("4 - 6 = -2"));
   }

   @Test
   public void testCalculateDivide() throws Exception {
     this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5"))
         .andExpect(status().isOk())
         .andExpect(content().string("30 / 5 = 6"));
   }

   @Test
   public void testCalculateDefault() throws Exception {
     this.mvc.perform(get("/math/calculate?x=30&y=5"))
         .andExpect(status().isOk())
         .andExpect(content().string("30 + 5 = 35"));
   }

   @Test
   public void testSumEndpoint() throws Exception {
     this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
         .andExpect(status().isOk())
         .andExpect(content().string("4 + 5 + 6 = 15"));
   }
   @Test
   public void testPostVolumeEndpoint() throws Exception {
        this.mvc.perform(post( "/math/volume/42/56/79"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 42x56x79 rectangle is 185808"));
   }
}