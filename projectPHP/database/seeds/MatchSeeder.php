<?php

use Illuminate\Database\Seeder;

class MatchSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('Match')->insert([
            'idMatch' => '1',
            'idAChaise' => '1',
            'idEquipeAL' => '1',
            'idEquipeR' => '1',
            'dateDebutM' => '2020-01-10',
            'dateFinM' => '2020-01-10',
            'idCourt' => '2',
            'idScore' => '5',
            'idGagnant' => '1',
            'tour' => '1',
        ]);
    }
}
