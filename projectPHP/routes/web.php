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

/* Route::get('/panier', 'PanierController@index')->name('panier.index');
Route::post('/panier', 'PanierController@store')->name('panier.store');
 */


Route::post('billets/choose', 'BilletsController@choose')->name('billets.choose');
Route::put('billets/{id}', 'BilletsController@update')->name('billet');
Route::get('billets/accueil', 'BilletsController@accueil')->name('billets.index');
Route::resource('/billets', 'BilletsController');

Route::post('coupon/create', ['uses' => 'CouponsController@save']);

Route::post('panier/{id}', 'CartController@update')->name('panier.update');

Route::delete('/coupon', 'CouponsController@supprimer')->name('coupon.delete');
Route::delete('/coupon/{id}', 'CouponsController@retirer')->name('coupon.retirer');
Route::post('/coupon', 'CouponsController@store')->name('coupon.store');
Route::resource('/coupon', 'CouponsController');

Route::get('/delete', function()
{
    session()->flush();
});

Route::get('panier', 'CartController@index')->name('panier.index');
Route::post('add', 'CartController@add');
Route::post('destroy/{id}', 'CartController@destroy')->name('panier.destroy');
/* Route::post('destroy', 'CartController@destroy')->name('panier.destroy'); */
Route::post('destroy', 'CartController@supprimer')->name('panier.supprimer');

Auth::routes();