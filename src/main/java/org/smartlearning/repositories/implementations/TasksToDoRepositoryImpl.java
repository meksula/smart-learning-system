package org.smartlearning.repositories.implementations;

import org.smartlearning.core.content.Task;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TasksToDoRepositoryImpl implements TasksToDoRepository {
    private JdbcOperations jdbcOperations;
    private final String FETCH_QUERY = "SELECT * FROM tasksToDo WHERE userId=?";
    private final String FETCH_QUERY_BY_TASK_ID = "SELECT * FROM tasksToDo WHERE taskId=?";
    private final String SAVE_QUERY = "INSERT INTO tasksToDo (userId, title, description, spendTime, branchOfScience, startDate) values(?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE tasksToDo SET spendTime=? WHERE taskId=?";

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Task> fetchTasksToDo(long userId) {
        ArrayList<Task> taskList = new ArrayList<>();
        jdbcOperations.queryForObject(FETCH_QUERY,
                (rs, rowNum) -> {
                    do {
                        Task task = new Task();
                        task.setTaskId(rs.getInt(1));
                        task.setUserId(rs.getInt(2));
                        task.setTitle(rs.getString(3));
                        task.setDescription(rs.getString(4));
                        task.setSpendTime(rs.getInt(5));
                        task.setBranchOfScience(rs.getString(6));
                        task.setStartDate(rs.getString(7));
                        task.setFinishDate(rs.getString(8));
                        taskList.add(task);
                    } while (rs.next());
                    return taskList;
                }, userId);

        return taskList;
    }

    @Override
    public void saveTaskToDo(Task task) {
        jdbcOperations.update(SAVE_QUERY,
                task.getUserId(),
                task.getTitle(),
                task.getDescription(),
                task.getSpendTime(),
                task.getBranchOfScience(),
                task.getStartDate());
    }

    @Override
    public Task fetchOneTaskByTaskId(long taskId) {
        Task task = new Task();
        jdbcOperations.queryForObject(FETCH_QUERY_BY_TASK_ID,
                (rs, rowNum) -> {
                    task.setTaskId(rs.getInt(1));
                    task.setUserId(rs.getInt(2));
                    task.setTitle(rs.getString(3));
                    task.setDescription(rs.getString(4));
                    task.setSpendTime(rs.getInt(5));
                    task.setBranchOfScience(rs.getString(6));
                    task.setStartDate(rs.getString(7));
                    task.setFinishDate(rs.getString(8));
                    return task;
                }, taskId);
        return task;
    }

    @Override
    public void updateTaskToDo(Task task) {
        jdbcOperations.update(UPDATE_QUERY, task.getSpendTime(), task.getTaskId());
    }
}
