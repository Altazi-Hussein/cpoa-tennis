<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Model;

/**
 * Class Match
 * 
 * @property int $idMatch
 * @property int $idAChaise
 * @property int $idEquipeAL
 * @property int $idEquipeR
 * @property Carbon $dateDebutM
 * @property Carbon $dateFinM
 * @property int $idCourt
 * @property int $idScore
 * @property int $idGagnant
 * @property int $tour
 *
 * @package App\Models
 */
class Match extends Model
{
	protected $table = 'Match';
	protected $primaryKey = 'idMatch';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idMatch' => 'int',
		'idAChaise' => 'int',
		'idEquipeAL' => 'int',
		'idEquipeR' => 'int',
		'idCourt' => 'int',
		'idScore' => 'int',
		'idGagnant' => 'int',
		'tour' => 'int'
	];

	protected $dates = [
		'dateDebutM',
		'dateFinM'
	];

	protected $fillable = [
		'idAChaise',
		'idEquipeAL',
		'idEquipeR',
		'dateDebutM',
		'dateFinM',
		'idCourt',
		'idScore',
		'idGagnant',
		'tour'
	];
}
