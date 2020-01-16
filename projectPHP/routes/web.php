<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');

Route::get('/panier', 'PanierController@index')->name('panier.index');

Route::get('billets/choose', 'BilletsController@choose');

Route::put('billets/{id}', 'BilletsController@update')->name('billet');

Route::resource('/billets', 'BilletsController');


Auth::routes();