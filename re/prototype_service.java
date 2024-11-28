package com.re;

import static java.util.stream.Collectors.toList;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
 
class Result {
 
    /*
     * Complete the 'countFaults' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY logs
     */
 
    public static int countFaults(int n, List<String> logs) {
        Map<String, Integer> errorCountMap = new HashMap<>();
        int replaceCount = 0;
 
        for (String log : logs) {
            // Split the log into serverId and status
            String[] parts = log.split(" ");
            String serverId = parts[0];
            String status = parts[1];
 
            // Increment the error count for this server if the status is "error"
            if (status.equals("error")) {
                errorCountMap.put(serverId, errorCountMap.getOrDefault(serverId, 0) + 1);
                // Check for replacement
                if (errorCountMap.get(serverId) == 3) {
                    replaceCount++;
                    errorCountMap.put(serverId, 0); // Reset after replacement
                }
            } else {
                // Reset the error count if the status is not an error
                errorCountMap.put(serverId, 0);
            }
 
            // Debugging output
            System.out.println("Log: " + log + ", Server: " + serverId + ", Status: " + status + ", Error Count: " + errorCountMap.get(serverId));
        }
 
        return replaceCount;
    }
}
 
public class prototype_service {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());
 
        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());
 
        int result = Result.countFaults(n, logs);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
 
//implement a prototype service to automate the deection and replacement of 
//faulty servers to improve the availability of an application.
//There are n servers with ids s1,s2,...,sn, and an array of strings, logs,
//of size m.Log format is "<server_id><success/error>",the id of the server, 
//and the status of the processed .request. If a paticular server id logs an error 
//for three consecutive requests, it is considered faulty and is replaced with a
//new server with the same id.
// 
//Given n and the array logs,find the number of times a faulty server was replaced.
// 
//Example 
//Suppose  n=2 and logs =["s1 error","s1 error","s2 error",
//                        "s1 error","s1 error","s2 success"].
//s1 was replaced one time.So, output should be 1.
// 
//Function Description
//Complete the function countFaults in the editor below.
// 
//countFaults has the following parameters:
//int n: the number of servers
//string logs[m]:the application logs
// 
//Returns int:the number of times servers were replaced
