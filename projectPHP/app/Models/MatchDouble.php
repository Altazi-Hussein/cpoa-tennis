<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class MatchDouble
 * 
 * @property int $idMatchDouble
 * @property int $idEquipeJ1
 * @property int $idEquipeJ2
 *
 * @package App\Models
 */
class MatchDouble extends Model
{
	protected $table = 'MatchDouble';
	protected $primaryKey = 'idMatchDouble';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idMatchDouble' => 'int',
		'idEquipeJ1' => 'int',
		'idEquipeJ2' => 'int'
	];

	protected $fillable = [
		'idEquipeJ1',
		'idEquipeJ2'
	];
}
