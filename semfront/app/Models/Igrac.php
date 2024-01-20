<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class Igrac extends Model
{
    use HasFactory;

    protected $table = 'igrac';
    public $primaryKey = 'IgracID';
    protected $fillable = [
        'ime',
        'prezime',
        'klub_id',
        'kategorija',
        'rejting',
        'email',
        'password'
    ];

    public function klub()
    {
        return $this->belongsTo(Klub::class);
    }
    public function prijava()
    {
        return $this->belongsTo(Prijava::class);
    }
}