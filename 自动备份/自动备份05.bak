[General]
SyntaxVersion=2
BeginHotkey=122
BeginHotkeyMod=4
PauseHotkey=0
PauseHotkeyMod=0
StopHotkey=123
StopHotkeyMod=0
RunOnce=1
EnableWindow=
MacroID=ffc08931-4aac-427e-91c0-85430a64a9fa
Description=我的脚本1
Enable=1
AutoRun=0
[Repeat]
Type=0
Number=1
[SetupUI]
Type=2
QUI=
[Relative]
SetupOCXFile=
[Comment]

[Script]
'==========以下是按键精灵录制的内容==========
UserVar Shift=15 "设置内容"
UserVar N=0 "设置内容"
hLinkShape = 295340658
errorFlag = 0
UserVar M=0 "设置内容"


While Shift > 0
	If errorFlag = 1 Then 
		KeyDown "BackSpace", 1
		Delay 1
		KeyUp "BackSpace", 1
		Delay 500
	End If
	
	
	N=0
	errorFlag = 1
	
	
	For 25
	MoveTo 180, 250+N*Shift
	Delay 300
	mouseShape = GetCursorShape(0)
	If mouseShape = hLinkShape Then 
	 
	 	errorFlag = 0
	 	
		LeftClick 1
		Delay 1
		LeftUp 1
		Delay 1500
		'点保存键
		MoveTo 103, 63
		LeftClick 1
		Delay 300
		'输入序号
		MoveTo 447, 576
		Delay 300
		LeftClick 1
		Delay 300
		M=M+1
		SayString M
		'移动到保存类型
		MoveTo 612, 603
		LeftClick 1
		Delay 300
		'选择txt
        MoveTo 622, 677
		LeftClick 1
		Delay 300
        KeyPress "Enter", 1
        KeyPress "Left", 1
		Delay 300
		KeyPress "Enter", 1

        Delay 1000
		KeyDown "BackSpace", 1
		Delay 1
		KeyUp "BackSpace", 1
		Delay 1000
	End If
	N=N+1
	Next
	
	IfColor 692, 236, "000099", 0 Then
		'拉下拉条
		MoveTo 690, 610
		LeftClick 1
		Delay 1300
		
		N=0
		For 25
		MoveTo 180, 250+N*Shift
		Delay 300
		mouseShape = GetCursorShape(0)
		If mouseShape = hLinkShape Then 
	 	
	 		errorFlag = 0
	 		
			LeftClick 1
			Delay 1
			LeftUp 1
			Delay 1500
			'点保存键
			MoveTo 103, 63
			LeftClick 1
			Delay 300
			'输入序号
			MoveTo 447, 576
			Delay 300
			LeftClick 1
			Delay 1300
			M=M+1
			SayString M
			'移动到保存类型
			MoveTo 612, 603
			LeftClick 1
			Delay 300
			'选择txt
        	MoveTo 622, 677
			LeftClick 1
			Delay 300
        	KeyPress "Enter", 1
        	KeyPress "Left", 1
			Delay 300
			KeyPress "Enter", 1
	
        	Delay 1000
			KeyDown "BackSpace", 1
			Delay 1
			KeyUp "BackSpace", 1
			Delay 1
			
			'拉下拉条
			MoveTo 690, 610
			Delay 300
			LeftClick 1
			Delay 100
		End If
		N=N+1
		Next
	End If

	
	MoveTo 300, 690
	Delay 1300
	mouseShape = GetCursorShape(0)
	If mouseShape = hLinkShape Then 
		LeftClick 1
		LeftUp 1
		Delay 1300
	Else 
		MoveTo 528, 682
		LeftClick 1
		LeftUp 1
		Delay 1300
	End If
	
	IfColor 530, 678, "6F6F6F", 0 Then
		EndScript
	End If	

EndWhile

'==========以上是按键精灵录制的内容==========
