<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * Class ScoreMatch
 * 
 * @property int $idScore
 * @property int $tour
 * @property int $score1
 * @property int $score2
 *
 * @package App\Models
 */
class ScoreMatch extends Model
{
	protected $table = 'ScoreMatch';
	protected $primaryKey = 'idScore';
	public $incrementing = false;
	public $timestamps = false;

	protected $casts = [
		'idScore' => 'int',
		'tour' => 'int',
		'score1' => 'int',
		'score2' => 'int'
	];

	protected $fillable = [
		'tour',
		'score1',
		'score2'
	];
}
