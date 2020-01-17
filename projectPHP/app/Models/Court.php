<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class Court
 * 
 * @property int $idCourt
 * @property string $typeCourt
 *
 * @package App\Models
 */
class Court extends Model
{
	protected $table = 'Court';
	protected $primaryKey = 'idCourt';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idCourt' => 'int'
	];

	protected $fillable = [
		'typeCourt'
	];
}
