<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class Joueur
 * 
 * @property int $idJoueur
 * @property int $idEquipeJ
 * @property string $nationaliteJ
 * @property string $nomJ
 * @property string $prenomJ
 *
 * @package App\Models
 */
class Joueur extends Model
{
	protected $table = 'Joueur';
	protected $primaryKey = 'idJoueur';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idJoueur' => 'int',
		'idEquipeJ' => 'int'
	];

	protected $fillable = [
		'idEquipeJ',
		'nationaliteJ',
		'nomJ',
		'prenomJ'
	];
}
