package com.example.homework41.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework41.Model.BooksModel;
import com.example.homework41.R;

import java.util.ArrayList;

public class BooksViewModel extends ViewModel {

 public MutableLiveData<ArrayList<BooksModel>> books = new MutableLiveData<ArrayList<BooksModel>>();
 public ArrayList<BooksModel> list = new ArrayList<>();
 public MutableLiveData<BooksModel> model= new MutableLiveData<>();

 public void select(BooksModel item) {
  model.setValue(item);
 }
 public LiveData<BooksModel> getSelected() {
  return model;
 }
 public void addBook(){
  list.add(new BooksModel("Мастер и Маргарита","Роман «Мастер и Маргарита» - произведение, в котором находят отражения философские, а значит вечные темы. Любовь и предательство, добро и зло, истина и ложь, поражают своей дуальностью, отражая противоречивость и, вместе с тем, полноту человеческой природы.", R.drawable.master));
  list.add(new BooksModel("Гарри Поттер","«Га́рри По́ттер» (англ. «Harry Potter») — серия из семи романов в жанре фэнтези, написанных английской писательницей Дж. К. Роулинг. Книги представляют собой хронику приключений юного волшебника Гарри Поттера, а также его друзей Рона Уизли и Гермионы Грейнджер, обучающихся в Школе чародейства и волшебства Хогвартс. Основной сюжет посвящён противостоянию Гарри и тёмного волшебника по имени лорд Волан-де-Морт, в чьи цели входит обретение бессмертия и порабощение магического мира.", R.drawable.garry));
  books.setValue(list);
 }

}
