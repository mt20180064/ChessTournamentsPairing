<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class TurnirResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'TurnirID' => $this->resource->TurnirID,
            'Naziv' => $this->resource->Naziv,
            'Nesto' => $this->resource->Mesto,
            'Tip' => $this->resource->Tip,
            'Tempo' => $this->resource->Tempo,
            'Status' => $this->resource->Status,
            'Slika' => $this->resource->Slika

        ];
    }
}