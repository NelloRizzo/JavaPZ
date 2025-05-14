import { Component } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-admin',
  imports: [NgFor],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss'
})
export class AdminComponent {
  model: string[] = [];
  error: boolean = false;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.adminService.getAdminData().subscribe(r => this.model = r);
  }
}
