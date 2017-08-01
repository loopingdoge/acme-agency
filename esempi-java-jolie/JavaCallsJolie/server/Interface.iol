type SumPair: void {
	.x: double
	.y: double
}

type SumResponse: void {
	.result: double
}

type StringArray: void {
	.strings[0, *]: string
}

type ConcatenateResponse: void {
	.result: string
}

interface ServiceForJavaInterface {
	RequestResponse:
		sum(SumPair)(SumResponse),
		concatenate(StringArray)(ConcatenateResponse)
}
