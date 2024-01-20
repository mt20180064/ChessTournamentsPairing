<?php

use App\Http\Controllers\IgracTurniriController;
use App\Http\Controllers\TurnirController;
use App\Http\Controllers\IgracController;
use App\Http\Controllers\KlubController;
use App\Http\Controllers\PrijavaController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\API\AuthController;
use App\Http\Controllers\IgracPrijavaController;
use PHPUnit\Event\Test\TestStubForIntersectionOfInterfacesCreated;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/igrac', function (Request $request) {
    return $request->user();
});
Route::post('/register', [AuthController::class, 'register']);
Route::post('/login', [AuthController::class, 'login']);
Route::post('/logout', [AuthController::class, 'logout']);
Route::resource('turnir', TurnirController::class)->only(['index', 'show']);
Route::resource('igrac', IgracController::class)->only(['index', 'show', 'store']);
Route::resource('prijava', PrijavaController::class)->only(['index', 'store', 'destroy']);
Route::resource('klub', KlubController::class)->only(['index']);
Route::resource('igrac/{id}/prijava', IgracTurniriController::class)->only(['index']);
Route::resource('prijava/{id}/igrac', IgracPrijavaController::class)->only(['index']);