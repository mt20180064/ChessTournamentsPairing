<?php

namespace App\Http\Controllers;

use App\Models\Klub;
use App\Http\Controllers\Controller;
use App\Http\Resources\KlubResource;
use Illuminate\Http\Request;

class KlubController extends Controller
{
    public function index()
    {
        $klub = Klub::all();
        return KlubResource::collection($klub);
    }
}