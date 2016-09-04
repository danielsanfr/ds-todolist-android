package br.com.danielsan.dstodolist.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by daniel on 04/09/16.
 */
@Entity(active = true)
public class TaskList {

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String title;
    @ToMany(referencedJoinProperty = "listId")
    private List<Task> tasks;
    @NotNull
    private Date updatedAt;
    @NotNull
    private Date createdAt;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 879176737)
    private transient TaskListDao myDao;
    @Generated(hash = 870883726)
    public TaskList(Long id, @NotNull String title, @NotNull Date updatedAt,
            @NotNull Date createdAt) {
        this.id = id;
        this.title = title;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
    @Generated(hash = 818992932)
    public TaskList() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1007176713)
    public List<Task> getTasks() {
        if (tasks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskDao targetDao = daoSession.getTaskDao();
            List<Task> tasksNew = targetDao._queryTaskList_Tasks(id);
            synchronized (this) {
                if(tasks == null) {
                    tasks = tasksNew;
                }
            }
        }
        return tasks;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 668181820)
    public synchronized void resetTasks() {
        tasks = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1522985075)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskListDao() : null;
    }

}
