<?php

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        // $this->call(UsersTableSeeder::class);
        $this->call(BilletsSeeder::class);
        $this->call(LicenceSeeder::class);
        /* $this->call(MatchSeeder::class); */
        $this->call(CouponSeeder::class);
    }
}
