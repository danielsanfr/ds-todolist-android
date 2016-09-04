package br.com.danielsan.dstodolist.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by daniel on 04/09/16.
 */
@Entity(active = true)
public class Task {

    @Id(autoincrement = true)
    private long id;
    @NotNull
    private long listId;
    @NotNull
    private String title;
    private String notes;
    @NotNull
    private boolean isFavorite;
    private Date dueAt;
    private Date completedAt;
    @NotNull
    private Date updatedAt;
    @NotNull
    private Date createdAt;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;
    @Generated(hash = 2144549450)
    public Task(long id, long listId, @NotNull String title, String notes,
            boolean isFavorite, Date dueAt, Date completedAt,
            @NotNull Date updatedAt, @NotNull Date createdAt) {
        this.id = id;
        this.listId = listId;
        this.title = title;
        this.notes = notes;
        this.isFavorite = isFavorite;
        this.dueAt = dueAt;
        this.completedAt = completedAt;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getListId() {
        return this.listId;
    }
    public void setListId(long listId) {
        this.listId = listId;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNotes() {
        return this.notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public boolean getIsFavorite() {
        return this.isFavorite;
    }
    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    public Date getDueAt() {
        return this.dueAt;
    }
    public void setDueAt(Date dueAt) {
        this.dueAt = dueAt;
    }
    public Date getCompletedAt() {
        return this.completedAt;
    }
    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
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
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }

}
