<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateBilletsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        if(!Schema::hasTable('billets')){
        Schema::create('billets', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->string('typeMatch')->nullable();
            $table->float('prix')->nullable();
            $table->integer('quantite')->nullable();
            $table->timestamps();
        });
    }
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function billet()
    {
    return $this->hasMany(Coupon::class);
    }
}
