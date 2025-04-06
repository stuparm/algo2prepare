package com.algo2prepare.leetcode;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class Summary {

    public static void main(String[] args) throws Exception {
        Summary summary = new Summary();
        String[] taskSummary = summary.tasksSummary();
        for (String task : taskSummary) {
            System.out.println(task);
        }
    }

    public String[] tasksSummary() throws Exception {
        Set<Class> classes = getTaskClasses();
        String[] summary = new String[classes.size()];
        int index = 0;
        for(Class taskClass : classes) {
            Object taskObj = taskClass.getConstructor().newInstance();
            Task task = (Task) taskObj;

            StringBuilder sb = new StringBuilder();
            String status = "❌";
            if (task.status()) {
                status = "✅";
            }
            sb.append(task.id()).append(" - ").append(task.name()).append(" - ").append(status);
            summary[index++] = sb.toString();

        }

        return summary;
    }

    private Set<Class> getTaskClasses() {
        Reflections reflections = new Reflections("com.algo2prepare.leetcode", new SubTypesScanner(false));
        return reflections.getSubTypesOf(Task.class)
                .stream()
                .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

}
