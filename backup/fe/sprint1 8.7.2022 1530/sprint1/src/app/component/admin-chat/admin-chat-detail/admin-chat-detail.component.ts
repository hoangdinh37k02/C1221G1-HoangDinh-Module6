import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import 'firebase/database';
import firebase from "firebase/app";
import "firebase/database";
import {snapshotToArray} from '../admin-chat.component';
import {environment} from '../../../../environments/environment';
import {getTimeStamp} from '../../../utils/time-stamp.utils';

@Component({
  selector: 'app-admin-chat-detail',
  templateUrl: './admin-chat-detail.component.html',
  styleUrls: ['./admin-chat-detail.component.css']
})
export class AdminChatDetailComponent implements OnInit {
  @ViewChild('chatContent') chatContent: ElementRef;
  scrollTop: number = null;
  adminChat = environment.adminChat;
  chatForm: FormGroup;
  uuid = '';
  user: any;
  chats = [];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.uuid = route.snapshot.paramMap.get('roomId');
    firebase.database().ref('chats/' + this.uuid).on('value', resp => {
      this.chats = [];
      this.chats = snapshotToArray(resp);
      setTimeout(() => this.scrollTop = this.chatContent.nativeElement.scrollHeight, 200);
    });
    firebase.database().ref('users/').orderByChild('uuid').equalTo(this.uuid).once('value').then((resp2: any) => {
        this.user = snapshotToArray(resp2)[0];
      }
    );
  }

  ngOnInit(): void {
    this.chatForm = this.formBuilder.group({
      'message': [null, Validators.required]
    });
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @ param
   * @return handle chat message submit to Chats in FRD
   */
  onChatSubmit() {
    const chat = this.chatForm.value;
    chat.uuid = this.uuid;
    chat.name = this.adminChat.name;
    chat.createdAt = getTimeStamp();
    firebase.database().ref('chats/' + this.uuid).push().set(chat);
    firebase.database().ref('rooms/' + this.uuid).once('value').then(res => {
      const room = res.val();
      firebase.database().ref('rooms/' + this.uuid).update({...room, lastMessagePost: getTimeStamp(), isSeen: true});
    });
    this.chatForm.reset();
  }
}
