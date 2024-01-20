<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class PrijavaResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'PrijavaID' => $this->resource->PrijavaID,
            'IgracID' => $this->resource->IgracID,
            'TurnirID' => $this->resource->TurnirID,
        ];
    }
}