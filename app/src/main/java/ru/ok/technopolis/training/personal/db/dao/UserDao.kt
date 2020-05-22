package ru.ok.technopolis.training.personal.db.dao

import androidx.room.*
import ru.ok.technopolis.training.personal.db.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id = :id")
    fun getById(id: Long): UserEntity

    @Query("SELECT * FROM UserEntity WHERE email = :email")
    fun getByEmail(email: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity): Long

    @Insert
    fun insert(userList: List<UserEntity>): List<Long>

    @Update
    fun update(user: UserEntity): Int

    @Update
    fun update(userList: List<UserEntity>): Int

    @Delete
    fun delete(user: UserEntity): Int
}