<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class MatchSimple
 * 
 * @property int $idMatchSimple
 * @property int $idJoueur1
 * @property int $idJoueur2
 * @property bool $tournoi
 *
 * @package App\Models
 */
class MatchSimple extends Model
{
	protected $table = 'MatchSimple';
	protected $primaryKey = 'idMatchSimple';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idMatchSimple' => 'int',
		'idJoueur1' => 'int',
		'idJoueur2' => 'int',
		'tournoi' => 'bool'
	];

	protected $fillable = [
		'idJoueur1',
		'idJoueur2',
		'tournoi'
	];
}
