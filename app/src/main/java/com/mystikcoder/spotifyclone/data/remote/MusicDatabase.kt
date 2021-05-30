package com.mystikcoder.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.mystikcoder.spotifyclone.data.entities.Song
import com.mystikcoder.spotifyclone.utilities.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songsCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try {
            songsCollection.get().await().toObjects(Song::class.java)
        }catch (e: Exception){
            emptyList()
        }
    }

}