<?php

namespace App\Http\Controllers;

use App\Models\Turnir;
use App\Http\Controllers\Controller;
use App\Http\Resources\TurnirResource;
use Illuminate\Http\Request;

class TurnirController extends Controller
{
    public function index()
    {
        $turnir = Turnir::all();
        return TurnirResource::collection($turnir);
    }

    public function show(Turnir $turnir)
    {
        return new TurnirResource($turnir);
    }





}