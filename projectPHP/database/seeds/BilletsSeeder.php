<?php

use Illuminate\Database\Seeder;

class BilletsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $i = 0;
    while($i < 5)
    {
        DB::table('billets')->insert([
            'typeMatch'=>Str::random(15),
            'prix'=>rand(15,20),
            'quantite'=>rand(10,100)
        ]);
        $i = $i +1;
    }
    }
}
