type SessionType: void {
	.nextUser: string
	.processId: string
	.state: string
}

type SessionElementAdd: void {
	.nextUser: string
	.processId: string
	.state: string
}

type SessionAddResponse: void {
	.message: string
}

type SessionElementRemove: void {
	.processId: string
}

type SessionRemoveResponse: void {
	.message: string
}

type SessionElementGet: void {
	.username: string
}

type SessionGetResponse: void {
	.sessions[0, *]: SessionType
	.message: string
}

type InformDepositElement: void {
	.processId: string
	.bankOpId: string
}

type InformDepositResponse: void {
	.message: string
}


interface ACMESessionManager {
	RequestResponse:
		addSession(SessionElementAdd)(SessionAddResponse),
		removeSession(SessionElementRemove)(SessionRemoveResponse),
		getSessions(SessionElementGet)(SessionGetResponse)
}

interface ClientSessionManager {
	RequestResponse:
		getSessions(SessionElementGet)(SessionGetResponse),
		informDepositDone(InformDepositElement)(InformDepositResponse)
}
