<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Prijava extends Model
{
    use HasFactory;
    protected $table = 'prijava';
    public $primaryKey = 'PrijavaID';
    protected $fillable = [
        'IgracID',
        'TurnirID',
    ];
    public function igrac()
    {
        return $this->hasMany(Igrac::class);
    }

    public function turnir()
    {
        return $this->hasMany(Turnir::class);
    }
}