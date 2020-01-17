<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class RamasseurDeBalle
 * 
 * @property int $idRamasseur
 * @property int $idEquipeR
 * @property string $nomR
 * @property string $prenomR
 *
 * @package App\Models
 */
class RamasseurDeBalle extends Model
{
	protected $table = 'RamasseurDeBalle';
	protected $primaryKey = 'idRamasseur';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idRamasseur' => 'int',
		'idEquipeR' => 'int'
	];

	protected $fillable = [
		'idEquipeR',
		'nomR',
		'prenomR'
	];
}
