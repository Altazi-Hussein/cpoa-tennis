<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Str;

class LicenceSeeder extends Seeder

{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'idLicencie' => rand(1,10),
        ]); 
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'idLicencie' => rand(1,10),
        ]);
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'idLicencie' => rand(1,10),
        ]);
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'id' => rand(1,10),
        ]);
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'id' => rand(1,10),
        ]);
        DB::table('licences')->insert([
            'code' => Str::random(10),
            'id' => rand(1,10),
        ]);
    }
}
