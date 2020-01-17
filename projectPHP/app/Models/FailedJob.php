<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class FailedJob
 * 
 * @property int $id
 * @property string $nom
 * @property float $prix
 * @property int $quantite
 *
 * @package App\Models
 */
class FailedJob extends Model
{
	protected $table = 'failed_jobs';
	public $timestamps = false;

	protected $casts = [
		'prix' => 'float',
		'quantite' => 'int'
	];

	protected $fillable = [
		'nom',
		'prix',
		'quantite'
	];
}
