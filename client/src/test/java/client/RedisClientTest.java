package client;

import org.junit.Test;
import redis.client.RedisClient;
import redis.client.SocketPool;
import redis.reply.BulkReply;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;

/**
 * Test the boilerplate
 * <p/>
 * User: sam
 * Date: 11/5/11
 * Time: 10:20 PM
 */
public class RedisClientTest {
  @Test
  public void testIt() throws IOException, ExecutionException, InterruptedException {
    RedisClient redisClient = new RedisClient(new SocketPool("localhost", 6379));
    redisClient.set("test", "value");
    BulkReply test = (BulkReply) redisClient.get("test");
    assertEquals("value", new String(test.bytes));
  }
}