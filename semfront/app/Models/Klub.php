<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Klub extends Model
{
    protected $table = 'klub';
    public $primaryKey = 'KlubID';
    use HasFactory;
    protected $fillable = [
        'naziv',
        'grad',
    ];

    public function igrac()
    {
        return $this->hasMany(Igrac::class);
    }
}