package com.example.mytodo.data

import kotlinx.coroutines.flow.Flow

/**
 * データベースの操作を行うクラス
 */
class DatabaseItemsRepository(private val itemDao: ItemDao) :
    ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)
    override suspend fun insertItem(item: Item) = itemDao.insert(item)
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}