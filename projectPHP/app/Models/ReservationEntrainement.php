<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Model;

/**
 * Class ReservationEntrainement
 * 
 * @property int $idReservation
 * @property Carbon $dateDebutR
 * @property Carbon $dateFinR
 * @property int $idCourt
 * @property int $idJoueur
 * @property int $idPlanning
 *
 * @package App\Models
 */
class ReservationEntrainement extends Model
{
	protected $table = 'ReservationEntrainement';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idReservation' => 'int',
		'idCourt' => 'int',
		'idJoueur' => 'int',
		'idPlanning' => 'int'
	];

	protected $dates = [
		'dateDebutR',
		'dateFinR'
	];

	protected $fillable = [
		'dateFinR',
		'idPlanning'
	];
}
