<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class KlubResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public static $wrap = 'klub';
    public function toArray(Request $request): array
    {
        return [
            'KlubID' => $this->resource->KlubID,
            'Naziv' => $this->resource->Naziv,
            'Grad' => $this->resource->Grad,
        ];
    }
}