package com.encoders.roominkotlin

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun  UPdate(contact: Contact)

    @Delete
    suspend fun Delete(contact: Contact)

    @Query("SELECT * FROM contacts")
    fun get_Contact(): LiveData<List<Contact>>


}