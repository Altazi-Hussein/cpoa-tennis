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
        /* $i = 0;
    while($i < 5)
    {
        DB::table('billets')->insert([
            'typeMatch'=>Str::random(15),
            'prix'=>rand(15,20),
            'quantite'=>rand(10,100)
        ]);
        $i = $i +1;
    } */
    DB::table('billets')->insert([
        'id' => '1',
        'typeMatch' => 'Grand Public',
        'prix' => '20',
        'quantite' => '100',
    ]);

    DB::table('billets')->insert([
        'id' => '2',
        'typeMatch' => 'Promo',
        'prix' => '30',
        'quantite' => '200',
    ]);

    DB::table('billets')->insert([
        'id' => '3',
        'typeMatch' => 'Licenciés',
        'prix' => '15',
        'quantite' => '120',
    ]);

    DB::table('billets')->insert([
        'id' => '4',
        'typeMatch' => 'Journée de la Solidarité',
        'prix' => '15',
        'quantite' => '60',
    ]);

    DB::table('billets')->insert([
        'id' => '5',
        'typeMatch' => 'The Big Match',
        'prix' => '80',
        'quantite' => '300',
    ]);
    }
}
