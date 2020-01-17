<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Carbon\Carbon;
use Illuminate\Database\Eloquent\Model;

/**
 * Class Planning
 * 
 * @property int $idPlanning
 * @property Carbon $dateDebutP
 * @property Carbon $dateFinP
 *
 * @package App\Models
 */
class Planning extends Model
{
	protected $table = 'Planning';
	protected $primaryKey = 'idPlanning';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idPlanning' => 'int'
	];

	protected $dates = [
		'dateDebutP',
		'dateFinP'
	];

	protected $fillable = [
		'dateDebutP',
		'dateFinP'
	];
}
