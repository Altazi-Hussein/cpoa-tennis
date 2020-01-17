<?php

use Illuminate\Database\Seeder;

class CouponSeeder extends Seeder

{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('coupons')->insert([
            'code' => 'ABC123',
            'reduction' => 30,
        ]); 
    }
}
